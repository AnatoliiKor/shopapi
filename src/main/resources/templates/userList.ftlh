<#import "parts/common.ftlh" as c>
<@c.page>
    <a href="/shop">main page</a>
    <a href="/admin">admin</a>

    <div>User list</div>
    <table>
        <thead>
        <tr>
            <th> Name</th>
            <th> Password</th>
            <th> Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">edit</a></td>
                <td>
                    <form method="post" action="/user/delete?id=${user.id}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit">Delete</button>
                    </form>
                </td>

            </tr>

        <#else>
            No users
        </#list>

        </tbody>


    </table>




</@c.page>
