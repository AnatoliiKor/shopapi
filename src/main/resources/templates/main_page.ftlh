<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
<#--    <@l.logout/>-->
    <p>

    <h2> BIKES SHOP</h2>
    <p>
    <form method="get" action="shop/sort">
        <div> Sort by <select name="sort" size="1">
                <option selected="selected"><b>${sort}</b></option>
                <option value="name">model</option>
                <option>category</option>
                <option>colour</option>
                <option>brand</option>
                <option>price</option>
                <option>date</option>
            </select>
            Order by <select name="order" size="1" value="order">
                <option selected="selected"><b>${order}</b></option>
                <option value="ASC">Ascending</option>
                <option value="DESC">Descending</option>
            </select>
            <button type="submit">Apply</button>
        </div>
    </form>
    <p>
    <div>
        <form method="get" action="/shop">
            <input type="text" name="filter" value="${filter!}">
            <button type="submit">Search</button>
        </form>
        <form method="get" action="/shop/price">
            <label> min <input type="number" name="min" min="0" value=${minPrice} required> </label>
            <label> max <input type="number" name="max" min="0" max="10000" value=${maxPrice} required> </label>
            <button type="submit">Search</button>
        </form>
    </div>

    ${page+1}
    <a href="shop/page?p=${page-1}">Previous</a>
    <a href="shop/page?p=${page+1}">Next</a>

    <table class="table table-striped auto__table table-condensed text-center">
        <thead>
        <tr>
            <th> Photo</th>
            <th> model</th>
            <th> brand</th>
            <th> colour</th>
            <th> description</th>
            <th> category</th>
            <th> price</th>
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
    ${page+1}
    <a href="shop/page?p=${page-1}">Previous</a>
    <a href="shop/page?p=${page+1}">Next</a>
</@c.page>
