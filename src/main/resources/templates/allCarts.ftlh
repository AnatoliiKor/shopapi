<#import "parts/common.ftlh" as c>
<@c.page>
    <p>
    <a href="/admin">Back to ADMIN PAGE</a>
    <p>
    <a href="/allCarts?status=registered">registered</a>
    <a href="/allCarts?status=paid">paid</a>
    <a href="/allCarts?status=canceled">canceled</a>
    <div>
    Show ALL and SORT by
    <a href="/allCarts?sort=id">ID</a>
    <a href="/allCarts?sort=user">USER</a>
    <a href="/allCarts?sort=orderDate">DATE</a>
    <a href="/allCarts?sort=total">TOTAL</a>
    <a href="/allCarts?sort=status">STATUS</a>
</div>


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
                    ${cart.user.username!}
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
