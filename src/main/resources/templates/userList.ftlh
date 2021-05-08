<#import "parts/common.ftlh" as c>
<@c.page>

    <h2>Users list</h2>
    <table>
        <thead>
        <tr>
            <th> Name</th>
            <th> Email</th>
            <th> Is active </th>
            <th> Registered </th>
            <th> Role</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td><input type="checkbox" ${user.active?string("checked","")} disabled></td>
                <td>${user.registrationDate}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">edit</a></td>
                <td>
                    <form method="post" action="/user/delete?id=${user.id}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit">Delete</button>
                    </form>
                </td>
                <td><a href="/user/orders/${user.id}">Show user`s oders</a></td>
            </tr>

        <#else>
            No users
        </#list>

        </tbody>


    </table>




</@c.page>
