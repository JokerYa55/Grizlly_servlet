<#if direct_link??>
    <#assign direct="${direct_link}">
</#if>
<div class="alert">    
</div>
<div class="row">
    <div class="header_messages">
        ${msg["accountLinkTitle"]}        
    </div>
    <div class="info_message">
        <div class="alert alert-error">
            <#if errorMessage??>${errorMessage}</#if>
            direct = ${direct_link}
        </div>
        <#if accountLinkMsg??>${accountLinkMsg}</#if>
        
    </div>
</div>
<div>
    <form class="form-horizontal" id="kc-form-link" action="" method="POST">
        <div class="kc-input-group">
            <div id="idDivName">
                <div>
                    <input required type="text" class="" id="link_user_name" name="username" value=""/>
                    <label for="link_user_name" class="kc-input-label">${msg["labelLogin"]}</label>
                    <span class="kc-input-bar"></span>
                </div>
            </div>
        </div>        
        <div class="kc-input-group">
            <div id="idDivPassword">                
                <input required type="password" class="" id="link_user_password" name="password" value=""/>
                <label for="link_user_password" class="kc-input-label">${msg["labelPassword"]}</label>
                <span class="kc-input-bar"></span>
            </div>
        </div>        
        <div class="kc-form-buttons">
            <center>
                <input type="submit" class="" value="${msg["labelButtonLink"]}" />                
            </center> 
            
        </div>        
        <div class="url-group">
            <center>
                <#if direct=="false">
                    <a href="">Зарегистрироваться в ЕЛК</a>
                    <a href="">Logout</a>
                </#if>
                <a href="<#if redirectURI??>${redirectURI}</#if>">${msg["labelButtonCancel"]}</a>                
            </center>
        </div>
        <input type="hidden" name="direct" value="${direct_link}">
    </form>
</div>