<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring/>

<@c.page>

<#--    <bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">-->
<#--        <property name="basename" value="messages"/>-->
<#--    </bean>-->

    <@spring.message "check"/>

    <div>Hello, guest</div>

    <div>
        <a href="/login">Sign In</a>
    </div>
    <#if isAdmin>
            <a href="/admin">Admin</a>
    </#if>
    <div>
        <a href="/shop">View all products</a>
    </div>

    <div>
        <a href="/hello">Try languages</a>
        <a href="/hello2">Try languages</a>
    </div>
</@c.page>
