<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<#--    <@l.logout/>-->
    <p>

        <h2> BIKES SHOP</h2>
    <form method="get" action="/shop">
        <input type="text" name="filter" value="${filter!}">
        <button type="submit">Search</button>
    </form>

    <table>
        <thead>
        <tr>
            <th> Photo </th>
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
            <td><#if bike.filename??>
                    <img src="/img/${bike.filename}">
                </#if>
            </td>
<#--                <td>${bike.id}</td>-->
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
                   <#else>
            No products
        </#list>
        </tbody>
    </table>
</@c.page>
