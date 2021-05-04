<#import "parts/common.ftlh" as c>
<@c.page>
<#--<meta http-equiv="refresh" content="1">-->
    <p>
    <div class="alert alert-warning" role="alert">
        ${finish!}
    </div>
    <div><a href="/counter?clear=clear" class="link-danger">Clear all</a></div>
    <div><a href="/counter?clear=pause" class="link-warning"> Pause </a><a href="/counter?clear=continue"
                                                                           class="link-success"> Continue </a></div>
    <p>
        Time spent ${time}
    <form action="/counter?correct=${correct}">
        <input type="hidden" name="correct" value="${correct}">
        <button type="submit" class="btn btn-primary btn-lg">CORRECT(${correct})</button>
    </form>
    <p>
    <form method="get">
        <input type="hidden" name="wrong" value="${wrong}">
        <button type="submit" class="btn btn-warning btn-lg">WRONG(${wrong})</button>
    </form>
    Succes = ${succes}%
    <p>
        Time for one question = ${question} sec

    <p>
<#--    <form method="post" action="counter/add">-->
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->

<#--         <input type="hidden" name="correctAnswers" value = "${correct}"/>-->
<#--         <input type="text" name="timeMin" value = "${timeMin}"/>-->
<#--         <input type="hidden" name="succes" value = "${succes}"/>-->

<#--        <button type="submit">Save result</button>-->
<#--    </form>-->

    <#list results as result>
        <div>${result.localDate}: Time = ${result.time} min; Correct answers = ${result.correctAnswers}; Succes = ${result.succes}.</div>
    </#list>

</@c.page>
