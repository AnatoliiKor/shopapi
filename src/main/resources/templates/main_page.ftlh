<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <a href="/admin">admin</a>
<#--    <@l.logout/>-->
    <p>
        <a href="/cart">Cart</a>
        <b><a href="/user">Users</a></b>

    <div> Products list</div>
    <form method="get" action="/shop">
        <input type="text" name="filter" value="${filter!}">
        <button type="submit">Search</button>
    </form>

    <table>
        <thead>
        <tr>
            <th> id</th>
            <th> model</th>
            <th> brand</th>
            <th> colour</th>
            <th> description</th>
            <th> category</th>
            <th> price, $</th>
            <th> date</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list bikes as bike>
            <tr>
                <td>${bike.id}</td>
                <td>${bike.name}</td>
                <td>${bike.brand}</td>
                <td>${bike.colour}</td>
                <td>"${bike.description}"</td>
                <td>${bike.category}</td>
                <td>${bike.price}</td>
                <td>${bike.date}</td>
                <td>
                    <form method="post"
                          action="buy?id=${bike.id}&name=${bike.name}&price=${bike.price}&amount=${bike.amount}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit">Buy</button>
                    </form>
                </td>
            </tr>
        <#--            <form method="post" action="delete?id=${bike.id}">-->
        <#--                <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
        <#--                <button type="submit">Delete</button>-->
        <#--            </form>-->
        <#else>
            No products
        </#list>
        </tbody>
    </table>
</@c.page>
