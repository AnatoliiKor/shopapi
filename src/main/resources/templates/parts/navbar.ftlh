<#include "security.ftlh">
<#import "login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">BIKE SHOP</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/shop"><@spring.message "home_nav"/></a>
                </li>
                <#if isAdmin>
                    <li class="nav-item">
                        <a class="nav-link" href="/admin"><@spring.message "admin_nav"/></a>
                    </li>
                </#if>
                <li class="nav-item">
                    <a class="nav-link" href="/cart"><@spring.message "cart_nav"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/profile"><@spring.message "profile_nav"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/counter?clear=clear"><@spring.message "counter_nav"/></a>
                </li>
            </ul>

            <nav class="navbar navbar-light bg-light">
                <form class="form-inline">
                    <button class="btn btn-outline-primary" type="button"
                            onclick="window.location.href='?localeData=en'"> <@spring.message "en_button"/>
                    </button>
                    <button class="btn btn-outline-warning" type="button"
                            onclick="window.location.href='?localeData=uk'"><@spring.message "uk_button"/></button>
                </form>
            </nav>

            <div class="navbar-text">${name} &#8239</div>
            <#if name !="Guest"><@l.logout/>
            <#else>
                <a href="/login"> Sign In</a>
            </#if>
        </div>
    </div>
</nav>