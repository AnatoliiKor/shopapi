<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <@l.logout/>
    <p>
    <div> USER Buy products</div>
<p>
    <div> Products list</div>
    <form method="get" action="client">
             <input type="text" name="filter" value="${filter!}">
        <button type="submit">Search</button>

        ${message!""}
    </form>


    <#list products as product>
        <div>
            <i>id=${product.id}</i>
            <b>name=${product.name}</b>
            <span>price=${product.price}</span>
            <i>amount=${product.amount}</i>
            <b>description="${product.description}"</b>
            <strong>${product.authorName}</strong>

            <form method="post" action="buy?id=${product.id}">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit">Buy</button>
            </form>
        </div>
    <#else>
        No products
    </#list>


    <a href="/shop">main page</a>
</@c.page>