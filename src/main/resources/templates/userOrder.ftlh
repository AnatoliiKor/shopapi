<#import "parts/common.ftlh" as c>
<@c.page>
    <p>

        <table class="table table-striped auto__table table-condensed text-center">
            <tr>
                <td>
                    ${cart.id}
                </td>
                <td>
                    ${cart.orderDate}
                </td>
                <td>
                    ${cart.total}$
                </td>
                <td>
                    ${cart.status}
                        <form action="/statusChange/${cart.id}" method="post">
                            new status =<select name="status" size="1">
                                <option>paid</option>
                                <option>canceled</option>
                            </select>
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <button type="submit">apply</button>
                        </form>
                </td>
                <td>
                    <a href="/user/orders/${cart.user.id}">Back to ORDERS</a>
                </td>
            </tr>
        </table>

            <div class="card card-body">
                <table>

                    <#list cart.getCartItems() as cartItem>
                        <tbody>

                        <tr>
                            <td>${cartItem.bike.name}</td>
                            <td>${cartItem.getBike().brand}</td>
                            <td>${cartItem.getBike().colour}</td>
                            <td>"${cartItem.getBike().getDescription()}"</td>
                            <td>${cartItem.amount}</td>
                            <td>${cartItem.price}$</td>
                        </tr>
                        </tbody>

                    </#list>
                </table>
            </div>

</@c.page>
