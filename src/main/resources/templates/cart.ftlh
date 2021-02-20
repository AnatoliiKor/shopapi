<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <@l.logout/>
    <p>
    <div> Your CART</div>

    <table>
        <thead>
        <tr>
            <th> id</th>
            <th> model</th>
            <th> brand</th>
            <th> colour</th>
            <th> description</th>
            <th> amount</th>
            <th> price, $</th>
<#--            <th> date</th>-->
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list cartItems as cartItem>
            <tr>
                <td>${cartItem.id}</td>
                <td>${cartItem.getBike().name}</td>
                <td>${cartItem.getBike().brand}</td>
                <td>${cartItem.getBike().colour}</td>
                <td>"${cartItem.getBike().getDescription()}"</td>
                <td>${cartItem.amount}</td>
                <td>${cartItem.price}</td>
<#--                <td>${cartItem.getUser().username}</td>-->
<#--                <td>${cartItem.date}</td>-->
<#--                <td>-->
<#--                    <form method="post"-->
<#--                          action="buy?id=${bike.id}&name=${bike.name}&price=${bike.price}&amount=${bike.amount}">-->
<#--                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
<#--                        <button type="submit">Buy</button>-->
<#--                    </form>-->
<#--                </td>-->
                <td> <form method="post" action="deletecartitem?id=${cartItem.id}">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit">Delete</button>
                    </form> </td>
            </tr>
        <#else>
            No products
        </#list>
        </tbody>
    </table>

            <form method="post" action="checkout">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <button type="submit">Check out</button>
            </form>



    <a href="/shop">continue shopping</a>
</@c.page>