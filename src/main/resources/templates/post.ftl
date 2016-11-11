<#include 'header.ftl'>

<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->
<header class="intro-header" style="background-image:url('/webjars/zenpassvpn-startbootstrap-clean-blog/1.0.4/img/post-bg.jpg')">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="post-heading">
                    <h1>${post.title}</h1>
                    <h2 class="subheading">부제목</h2>
                    <span class="meta">Posted by <a href="#">Origoni</a> on ${post.regDate}</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Post Content -->
<article>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                ${post.content}
            </div>
        </div>
        
        <div class="pull-right">
			<form method="DELETE" action="/post/${post.id}">
				<button type="submit" class="btn btn-danger">Delete</button>
			</form>
		</div>
    </div>
</article>

<#include 'footer.ftl'>