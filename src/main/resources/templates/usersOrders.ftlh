<#import "parts/common.ftlh" as c>
<@c.page>
    <h2>${user.username}`s Orders</h2>
    <p>
        <a href="/user">Back to LIST of USERS</a>

    <#list carts as cart>
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
                </td>
                <td>
                    <a href="/show/${cart.id}">Show the order</a>
                </td>
            </tr>
        </table>
    <#else>
        No oders

    </#list>


</@c.page>
