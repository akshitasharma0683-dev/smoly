const API_BASE = "http://localhost:8080";


// =========================================
// REGISTER
// =========================================

async function registerUser() {

    const firstName =
        document.getElementById("firstName").value.trim();

    const lastName =
        document.getElementById("lastName").value.trim();

    const email =
        document.getElementById("email").value.trim();

    const password =
        document.getElementById("password").value;

    const username =
        firstName + " " + lastName;

    try {

        const response = await fetch(
            API_BASE + "/auth/register",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    username,
                    email,
                    password
                })
            }
        );

        if (!response.ok) {
            throw new Error("Registration failed");
        }

        alert("Registration successful!");

        window.location.href = "/login";

    } catch (error) {

        console.error(error);

        alert("Registration failed");
    }
}


// =========================================
// LOGIN
// =========================================

async function loginUser() {

    const email =
        document.getElementById("email").value.trim();

    const password =
        document.getElementById("password").value;

    if (!email || !password) {

        alert("Please enter your email and password");

        return;
    }

    try {

        const response = await fetch(
            API_BASE + "/auth/login",
            {
                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify({
                    email,
                    password
                })
            }
        );

        if (!response.ok) {
            throw new Error("Login failed");
        }

        /*
         * JWT is now stored by the backend
         * as an HttpOnly cookie.
         *
         * We DO NOT store it in localStorage.
         */

        window.location.href = "/dashboard";

    } catch (error) {

        console.error(error);

        alert("Invalid email or password");
    }
}


// =========================================
// LOGOUT
// =========================================

async function logout() {

    try {

        await fetch(
            API_BASE + "/auth/logout",
            {
                method: "POST"
            }
        );

    } catch (error) {

        console.error("Logout error:", error);

    } finally {

        window.location.href = "/login";
    }
}


// =========================================
// MOBILE NAVIGATION
// =========================================

document.addEventListener(
    "DOMContentLoaded",
    function () {

        const mobileToggle =
            document.getElementById("mobileToggle");

        const mobileMenu =
            document.getElementById("mobileMenu");

        const mobileMenuOverlay =
            document.getElementById("mobileMenuOverlay");

        const mobileMenuClose =
            document.getElementById("mobileMenuClose");

        const mobileMenuLinks =
            document.querySelectorAll(
                ".mobile-menu-link"
            );

        const navLinks =
            document.querySelectorAll(
                ".nav-link"
            );


        // =========================================
        // OPEN MOBILE MENU
        // =========================================

        function openMobileMenu() {

            console.log("Opening mobile menu");

            mobileToggle.classList.add("active");

            mobileMenu.classList.add("active");

            mobileMenuOverlay.classList.add("active");

            document.body.style.overflow = "hidden";
        }


        // =========================================
        // CLOSE MOBILE MENU
        // =========================================

        function closeMobileMenu() {

            console.log("Closing mobile menu");

            mobileToggle.classList.remove("active");

            mobileMenu.classList.remove("active");

            mobileMenuOverlay.classList.remove("active");

            document.body.style.overflow = "";
        }


        // =========================================
        // MOBILE TOGGLE
        // =========================================

        if (mobileToggle) {

            mobileToggle.addEventListener(
                "click",
                function (e) {

                    e.preventDefault();

                    e.stopPropagation();

                    if (
                        mobileMenu.classList.contains(
                            "active"
                        )
                    ) {

                        closeMobileMenu();

                    } else {

                        openMobileMenu();
                    }
                }
            );
        }


        // =========================================
        // CLOSE BUTTON
        // =========================================

        if (mobileMenuClose) {

            mobileMenuClose.addEventListener(
                "click",
                function (e) {

                    e.preventDefault();

                    closeMobileMenu();
                }
            );
        }


        // =========================================
        // OVERLAY
        // =========================================

        if (mobileMenuOverlay) {

            mobileMenuOverlay.addEventListener(
                "click",
                function () {

                    closeMobileMenu();
                }
            );
        }


        // =========================================
        // MOBILE LINKS
        // =========================================

        mobileMenuLinks.forEach(
            function (link) {

                link.addEventListener(
                    "click",
                    function () {

                        closeMobileMenu();

                        mobileMenuLinks.forEach(
                            function (l) {

                                l.classList.remove(
                                    "active"
                                );
                            }
                        );

                        this.classList.add("active");


                        const href =
                            this.getAttribute("href");


                        navLinks.forEach(
                            function (navLink) {

                                navLink.classList.remove(
                                    "active"
                                );

                                if (
                                    navLink.getAttribute(
                                        "href"
                                    ) === href
                                ) {

                                    navLink.classList.add(
                                        "active"
                                    );
                                }
                            }
                        );
                    }
                );
            }
        );


        // =========================================
        // DESKTOP NAV LINKS
        // =========================================

        navLinks.forEach(
            function (link) {

                link.addEventListener(
                    "click",
                    function () {

                        closeMobileMenu();


                        navLinks.forEach(
                            function (navLink) {

                                navLink.classList.remove(
                                    "active"
                                );
                            }
                        );


                        if (
                            !this.classList.contains(
                                "cta-button"
                            )
                        ) {

                            this.classList.add(
                                "active"
                            );


                            const href =
                                this.getAttribute(
                                    "href"
                                );


                            mobileMenuLinks.forEach(
                                function (mobileLink) {

                                    mobileLink.classList.remove(
                                        "active"
                                    );

                                    if (
                                        mobileLink.getAttribute(
                                            "href"
                                        ) === href
                                    ) {

                                        mobileLink.classList.add(
                                            "active"
                                        );
                                    }
                                }
                            );
                        }
                    }
                );
            }
        );


        // =========================================
        // ESCAPE KEY
        // =========================================

        document.addEventListener(
            "keydown",
            function (e) {

                if (
                    e.key === "Escape" &&
                    mobileMenu &&
                    mobileMenu.classList.contains(
                        "active"
                    )
                ) {

                    closeMobileMenu();
                }
            }
        );


        // =========================================
        // NAVBAR SCROLL EFFECT
        // =========================================

        window.addEventListener(
            "scroll",
            function () {

                const navbar =
                    document.querySelector(
                        ".navbar-container"
                    );

                if (!navbar) {
                    return;
                }

                const scrollTop =
                    window.pageYOffset ||
                    document.documentElement.scrollTop;


                if (scrollTop > 50) {

                    navbar.classList.add(
                        "scrolled"
                    );

                } else {

                    navbar.classList.remove(
                        "scrolled"
                    );
                }
            }
        );


        // =========================================
        // FLOATING CIRCLES
        // =========================================

        const floatingCircles =
            document.querySelectorAll(
                ".floating-circle"
            );

        floatingCircles.forEach(
            function (circle) {

                circle.addEventListener(
                    "mouseenter",
                    function () {

                        this.style.transform =
                            "scale(1.2)";
                    }
                );

                circle.addEventListener(
                    "mouseleave",
                    function () {

                        this.style.transform =
                            "scale(1)";
                    }
                );
            }
        );


        // =========================================
        // SMOOTH SCROLL
        // =========================================

        document
            .querySelectorAll(
                'a[href^="#"]'
            )
            .forEach(
                function (anchor) {

                    anchor.addEventListener(
                        "click",
                        function (e) {

                            e.preventDefault();

                            const target =
                                document.querySelector(
                                    this.getAttribute(
                                        "href"
                                    )
                                );

                            if (target) {

                                target.scrollIntoView({
                                    behavior: "smooth",
                                    block: "start"
                                });
                            }
                        }
                    );
                }
            );


        // =========================================
        // WINDOW RESIZE
        // =========================================

        window.addEventListener(
            "resize",
            function () {

                if (
                    window.innerWidth > 992 &&
                    mobileMenu &&
                    mobileMenu.classList.contains(
                        "active"
                    )
                ) {

                    closeMobileMenu();
                }
            }
        );

    }
);


// =========================================
// URL SHORTENER
// =========================================

async function shorten() {

    const url =
        document
            .getElementById("urlInput")
            .value
            .trim();


    if (!url) {

        alert("Please enter a URL");

        return;
    }


    try {

        const response =
            await fetch(
                "/shorten",
                {
                    method: "POST",

                    headers: {
                        "Content-Type":
                            "application/json"
                    },

                    body: JSON.stringify({
                        url: url
                    })
                }
            );


        if (!response.ok) {

            throw new Error(
                "Failed to create short URL"
            );
        }


        const data =
            await response.json();


        const result =
            document.getElementById(
                "result"
            );


        result.style.display = "block";


        result.innerHTML =
            `<a href="${data.shortUrl}" target="_blank">
                ${data.shortUrl}
             </a>`;


    } catch (error) {

        console.error(error);

        alert("Error creating short URL");
    }
}