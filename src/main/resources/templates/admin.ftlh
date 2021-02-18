<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <@l.logout/>
    <p>
    <div> ADMIN</div>
    <p>
    <div> Users list</div>
    <a href="/registration">Add new user</a>
    <#list users as user>
        <div>
            <i>id=${user.id}</i>
            <b>login=${user.username}</b>
            <span>password=${user.password}</span>
            <#--            <i>amount=${user.active}</i>-->

            <form method="post" action="deleteuser?id=${user.id}">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit">Delete</button>
            </form>
        </div>
    <#else>
        No users
    </#list>




    <div> Add new BIKE</div>

    <div>
        <form method="post" action="add">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="text" name="name" placeholder="model"/>
            <select name="brand" size="1">
                <option>Ardis</option>
                <option>Comanche</option>
                <option>Cube</option>
                <option>Discovery</option>
                <option>Focus</option>
                <option>Santa Cruz</option>
                <option>other</option>
            </select>
            <select name="colour" size="1">
                <option>red</option>
                <option>blue</option>
                <option>green</option>
                <option>black</option>
                <option>yellow</option>
                <option>white</option>
            </select>
            <input type="text" name="description" placeholder="description" value="No description"/>
            <select name="category" size="1">
                <option>utility bicycle</option>
                <option>mountain bicycle</option>
                <option>racing bicycle</option>
                <option>touring bicycle</option>
            </select>
            <input type="text" name="price" placeholder="price"/>
            <input type="text" name="amount" placeholder="amount"/>
            <button type="submit">Add</button>

        </form>
    </div>

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
                    <form method="post">
<#--                          action="delate?id=${bike.id}">-->
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit">Delete</button>
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

    <a href="/shop">main page</a>

</@c.page>
