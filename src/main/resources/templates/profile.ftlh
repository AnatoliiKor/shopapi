<#import "parts/common.ftlh" as c>
<@c.page>
    <a href="/shop">main page</a>
    <p>
    <div>My Orders List</div>



    <#list carts as cart>
        <p>
            <i>Order date is ${cart.orderDate}</i>
            <i>Order status is ${cart.status}</i>
            <i>Order total is ${cart.total}</i>

        <table>
        <thead>
        <tr>
            <th> model</th>
            <th> brand</th>
            <th> colour</th>
            <th> description</th>
            <th> amount</th>
            <th> price, $</th>
            <th></th>
        </tr>
        </thead>
        <#list cart.getCartItems() as cartItem>
            <tbody>

            <tr>
                <td>${cartItem.bike.name}</td>
                <td>${cartItem.getBike().brand}</td>
                <td>${cartItem.getBike().colour}</td>
                <td>"${cartItem.getBike().getDescription()}"</td>
                <td>${cartItem.amount}</td>
                <td>${cartItem.price}</td>
            </tr>
            </tbody>

        </#list>
        </table>
    <#else>
        No oders

    </#list>








</@c.page>
