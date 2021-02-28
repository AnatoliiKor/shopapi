<#import "parts/common.ftlh" as c>

<@c.page>

    <h2> Add new BIKE</h2>

    <div>
        <form method="post" action="add" enctype="multipart/form-data">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div> model = <input type="text" name="name" /></div>
                        <div> brand = <select name="brand" size="1">
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
                        <div>description <input type="text" name="description" value="No description"/>
                        </div>
                        <div> category = <select name="category" size="1">
                        <option>utility bicycle</option>
                        <option>mountain bicycle</option>
                        <option>racing bicycle</option>
                        <option>touring bicycle</option>
                        </select></div>
                        <div>price <input type="text" name="price" /> $ </div>
                        <div>amount <input type="text" name="amount" /></div>
                        <div>Select image <input type="file" name="file" /></div>

            <button type="submit">Add</button>

        </form>
    </div>

</@c.page>
