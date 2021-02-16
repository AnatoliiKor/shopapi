<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <a href="/admin">admin</a>
    <@l.logout/>
    <p>
    <a href="/client">Cart</a>
        <b><a href="/user">Users</a></b>

    <div> Products list</div>
    <form method="get" action="/shop">
        <input type="text" name="filter" value="${filter!}">
        <button type="submit">Search</button>
    </form>
    <#list bikes as bike>
        <div>
            <i>id=${bike.id}</i>
            <b>category=${bike.category}</b>
            <b>brand=${bike.brand}</b>
            <b>name=${bike.name}</b>
            <b>colour=${bike.colour}</b>
            <b>description="${bike.description}"</b>
            <span>price=${bike.price}</span>
            <i>amount=${bike.amount}</i>

            <form method="post"
                  action="edit?id=${bike.id}&name=${bike.name}&price=${bike.price}&amount=${bike.amount}">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit">Edit</button>
            </form>

            <form method="post" action="delete?id=${bike.id}">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit">Delete</button>
            </form>
        </div>
    <#else>
        No products
    </#list>
</@c.page>
