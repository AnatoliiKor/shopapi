<#import "parts/common.ftlh" as c>
<@c.page>
   <h2>${user.username}</h2>
    Email: ${user.email}
    <a href="email">Change Email</a>
    <p>
    <a href="password">Change Password</a>

    <p>
    <h2>My Orders List</h2>
            <button class="btn btn-info" type="button" data-bs-toggle="collapse" data-bs-target="#collapseBikes" aria-expanded="false" aria-controls="collapseBikes">
                Look bikes
            </button>

    <#list carts as cart>
        <p>
            <div><b>${cart.orderDate}</b></div>
                <div><i>Order status is ${cart.status}</i></div>
                    <div><i>Order total is ${cart.total} $</i></div>
        <p>
        </p>
        <div class="collapse" id="collapseBikes">
            <div class="card card-body">
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
            </div>
        </div>


    <#else>
        No oders

    </#list>








</@c.page>
