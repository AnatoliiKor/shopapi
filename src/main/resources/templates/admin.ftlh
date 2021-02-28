<#import "parts/common.ftlh" as c>

<@c.page>
    <p>
    <h2> ADMIN</h2>

    <p>
        <a href="/registration">Add new user</a>
    <p>
        <a href="/user">Show all users</a>
    <p>
        <a href="/newbike">Add new BIKE</a>

    <p>
    <div> Products list</div>
    <form method="get" action="admin">
        <input type="text" name="filter" value="${filter!}">
        <button type="submit">Search</button>
        <#--        ${message!""}-->
    </form>
    <table>
        <thead>
        <tr>
            <th> Photo </th>
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
                <td><#if bike.filename??>
                        <img src="/img/${bike.filename}">
                    </#if>
                </td>
                <td>${bike.id}</td>
                <td>${bike.name}</td>
                <td>${bike.brand}</td>
                <td>${bike.colour}</td>
                <td>"${bike.description}"</td>
                <td>${bike.category}</td>
                <td>${bike.price}</td>
                <td>${bike.date}</td>
                <td><a href="/bike/${bike.id}">edit</a></td>
                <td>
                    <form method="post" action="delete?id=${bike.id}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>

        <#else>
            No products
        </#list>
        </tbody>
    </table>

</@c.page>
