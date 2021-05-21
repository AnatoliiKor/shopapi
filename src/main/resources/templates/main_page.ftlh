<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#import "/spring.ftl" as spring/>

<@c.page>
<#--    <@l.logout/>-->
    <p>

    <h2> <@spring.message "title"/> </h2>
    <p>
    <form method="get" action="shop/sort">
        <div> <@spring.message "sort_by"/> <select name="sort" size="1">
                <option selected="selected"><b>${sort}</b></option>
                <option value="model"><@spring.message "model_main"/></option>
                <option value="category"><@spring.message "category_main"/></option>
                <option value="colour"><@spring.message "colour_main"/></option>
                <option value="brand"><@spring.message "brand_main"/></option>
                <option value="price"><@spring.message "price_main"/></option>
                <option value="date"><@spring.message "date_main"/></option>
            </select>
            <@spring.message "order_by"/> <select name="order" size="1" value="order">
                <option selected="selected"><b>${order}</b></option>
                <option value="ASC"><@spring.message "ascending"/></option>
                <option value="DESC"><@spring.message "descending"/></option>
            </select>
            <button type="submit"><@spring.message "apply"/></button>
        </div>
    </form>
    <p>
    <div>
        <form method="get" action="/shop">
            <input type="text" name="filter" value="${filter!}">
            <button type="submit"><@spring.message "search_main"/></button>
        </form>
        <form method="get" action="/shop/price">
            <label> <@spring.message "min_price"/> <input type="number" name="min" min="0" value=${minPrice} required> </label>
            <label> <@spring.message "max_price"/> <input type="number" name="max" min="0" max="10000" value=${maxPrice} required> </label>
            <button type="submit"><@spring.message "search_main"/></button>
        </form>
    </div>

    ${page+1}
    <a href="shop/page?p=${page-1}"><@spring.message "previous_main"/></a>
    <a href="shop/page?p=${page+1}"><@spring.message "next_main"/></a>

    <table class="table table-striped auto__table table-condensed text-center">
        <thead>
        <tr>
            <th> <@spring.message "photo_main"/></th>
            <th> <@spring.message "model_main"/></th>
            <th> <@spring.message "brand_main"/></th>
            <th> <@spring.message "colour_main"/></th>
            <th> <@spring.message "description_main"/></th>
            <th> <@spring.message "category_main"/></th>
            <th> <@spring.message "price_main"/></th>
            <th> <@spring.message "date_main"/></th>
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
                        <button type="submit"><@spring.message "buy_main"/></button>
                    </form>
                </td>

            </tr>
        <#else>
            No products
        </#list>
        </tbody>
    </table>
    ${page+1}
    <a href="shop/page?p=${page-1}"><@spring.message "previous_main"/></a>
    <a href="shop/page?p=${page+1}"><@spring.message "next_main"/></a>
</@c.page>
