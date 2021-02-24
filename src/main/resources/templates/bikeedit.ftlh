<#import "parts/common.ftlh" as c>
<@c.page>
    Bike Editor

    <form method="post" action="/bike/${bike.id}">

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden" name="bikeId" value="${bike.id}"/>
        <div> model =  <input type="text" name="name" value="${bike.name}"/></div>
        <div> category =  ${bike.category}</div>
        <div> brand = ${bike.brand}</div>
        <div> colour = ${bike.colour}</div>
        <#--        <input type="text" name="category" value="${bike.category}"/>-->
        <#--        <input type="text" name="brand" value="${bike.brand}"/>-->
        <#--        <input type="text" name="colour" value="${bike.colour}"/>-->
        <div>description = <input type="text" name="description" value="${bike.description}"/></div>
        <div>price <input type="text" name="price" value="${bike.price}" $ /></div>
        <div>amount <input type="text" name="amount" value="${bike.amount}"/></div>
        <button type="submit">Save</button>
    </form>

</@c.page>
