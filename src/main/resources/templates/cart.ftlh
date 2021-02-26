<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <@l.logout/>
    <p>
    <div> Your CART</div>

    <table>
        <thead>
        <tr>
            <th> Photo </th>
            <th> model</th>
            <th> brand</th>
            <th> colour</th>
            <th> description</th>
            <th> amount</th>
            <th> price, $</th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        <#if cartItems??>
        <#list cartItems as cartItem>
            <tr>
                <td><#if cartItem.bike.filename??>
                        <img src="/img/${cartItem.bike.filename}">
                    </#if>
                </td>
                <td>${cartItem.bike.name}</td>
                <td>${cartItem.bike.brand}</td>
                <td>${cartItem.bike.colour}</td>
                <td>"${cartItem.bike.getDescription()}"</td>
                <td>${cartItem.amount}</td>
                <td>${cartItem.price}</td>
                <td> <form method="post" action="deletecartitem?id=${cartItem.bike.id}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit">Delete</button>
                    </form> </td>
            </tr>
        <#else>
            No products
        </#list>
        </#if>
                </tbody>
    </table>
    <p>
        <span style="color: green; font-size: large; ">  Total price is ${total} $   </span>
    <p>
            <form method="post" action="checkout">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit">Check out</button>
            </form>

    <a href="/shop">continue shopping</a>
</@c.page>