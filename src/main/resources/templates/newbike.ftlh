<#import "parts/common.ftlh" as c>

<@c.page>

    <h2> Add new BIKE</h2>

    <div>
        <form method="post" action="add" enctype="multipart/form-data">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div> model = <input type="text"  name="name" value="<#if bike??>${bike.name}</#if>" required/></div>
            <div> brand = <select name="brand" size="1" value="<#if bike??>${bike.brand}</#if>">
                    <option>Ardis</option>
                    <option>Comanche</option>
                    <option>Cube</option>
                    <option>Discovery</option>
                    <option>Focus</option>
                    <option>Santa Cruz</option>
                    <option>other</option>
                </select></div>
            <div> colour = <select name="colour" size="1">
                    <option>red</option>
                    <option>blue</option>
                    <option>green</option>
                    <option>black</option>
                    <option>yellow</option>
                    <option>white</option>
                </select></div>
            <div>description <input type="text" name="description" value="No description" required/>
            </div>
            <div> category = <select name="category" size="1">
                    <option>utility bicycle</option>
                    <option>mountain bicycle</option>
                    <option>racing bicycle</option>
                    <option>touring bicycle</option>
                </select></div>
            <div class="col-md-2">price <input type="text" name="price" value="<#if bike??>${bike.price!}</#if>"  class="form-control ${(priceError??)?string('is-invalid', '')}"
                              required/>
                <#if priceError??>
                    <div class="invalid-feedback">
                        ${priceError}
                    </div>
                </#if>
            </div>
            <div class="col-md-2">amount <input type="text" value="<#if bike??>${bike.amount!}</#if>" name="amount" class="form-control ${(amountError??)?string('is-invalid', '')}"
                               required/>
                <#if amountError??>
                    <div class="invalid-feedback">
                        ${amountError}
                    </div>
                </#if>
            </div>

            <div>Select image <input type="file" name="file"/></div>

            <button type="submit">Add</button>

        </form>
    </div>

</@c.page>
