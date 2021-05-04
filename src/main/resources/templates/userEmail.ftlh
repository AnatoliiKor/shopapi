<#import "parts/common.ftlh" as c>
<@c.page>
<h2>${user.username}</h2>

Your Email is "${user.email}"

<p>
    <form  action="/user/email"method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="col-md-2">
    Type new
<#--        <input type="text" name="userEmail" value="${user.email}"/>-->
    <input type="text" class="form-control ${(emailError??)?string('is-invalid', '')}" name="userEmail"/>
        <#if emailError??>
            <div class="invalid-feedback">
                ${emailError}
            </div>
        </#if>
        <input type="hidden" name="userId" value="${user.id}"/>
    </div>
    <input type="submit" value="Save Email"/>
<#--    <button type="submit">Save Email</button>-->
    </form>

    </@c.page>
