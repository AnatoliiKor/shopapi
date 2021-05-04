<#macro login path button>
    <form action="${path}" method="post">

        <div class="col-md-2">
            <label> User Name</label>
            <input type="text" class="form-control ${(usernameError??)?string('is-invalid', '')}"
                   value="<#if user??>${user.username}</#if>"
                   name="username"/>
            <#if usernameError??>
                <div class="invalid-feedback">
                    ${usernameError}
                </div>
            </#if>
        </div>
        <#if path=="/registration">
            <div class="col-md-2">
                <label> Email: </label>
                <input type="text" class="form-control ${(emailError??)?string('is-invalid', '')}"
                       value="<#if user??>${user.email}</#if>"
                       name="email"/>
                <#if emailError??>
                    <div class="invalid-feedback">
                        ${emailError}
                    </div>
                </#if>
            </div>
        </#if>
        <div class="col-md-2">
            <label> Password: </label>
            <input type="password" class="form-control ${(passwordError??)?string('is-invalid', '')}"
                   value="<#if user??>${user.password}</#if>"
                   name="password"/>
            <#if passwordError??>
                <div class="invalid-feedback">
                    ${passwordError}
                </div>
            </#if>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><input type="submit" value="${button}"/></div>
    </form>
</#macro>

<#macro logout>
    <div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="submit" value="Sign Out"/>
        </form>
    </div>
</#macro>