<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    Login page
    <p>
        <@l.login path="/login" button = "Sign In"/>
    <p>
        <a href="/registration">Registration</a>
    <p>
        <a href="/shop">Main page</a>

</@c.page>