package com.wjdgh823.simpleweb

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {

    private val webView: WebView by lazy {
        findViewById(R.id.webView)
    }

    private val addressBar: EditText by lazy {
        findViewById(R.id.addressBar)
    }

    private val goHomeButton: ImageButton by lazy {
        findViewById(R.id.goHomeButton)
    }

    private val goBackButton: ImageButton by lazy {
        findViewById(R.id.goBackButton)
    }

    private val goForwardButton: ImageButton by lazy {
        findViewById(R.id.goForwardButton)
    }

    private val refreshLayout: SwipeRefreshLayout by lazy {
        findViewById(R.id.refreshLayout)
    }

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViews()
        bindViews()
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) { // 히스토리에 뒤로 갈 수 있는 히스토리가 있으면
            webView.goBack()
        } else { // 히스토리가 없다면
            super.onBackPressed() // 모든게 종료된다.
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initViews(){
        webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true // 자바스크립트를 허용한다. (메뉴가 실행될 것이다)
            loadUrl(DEFAULT_URL)
        }
    }
    
    private fun bindViews() {

        goHomeButton.setOnClickListener {
            webView.loadUrl(DEFAULT_URL) // 웹뷰는 내용을 보여주는 공간이다.
        }

        addressBar.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE) {
                webView.loadUrl(v.text.toString())
            }
            return@setOnEditorActionListener false
        }

        goBackButton.setOnClickListener {
            webView.goBack() // 이전 버튼을 누르면 이전의 url로 넘어간다
        }

        goForwardButton.setOnClickListener {
            webView.goForward() // 다음 Url로 넘어간다.
        }

        refreshLayout.setOnRefreshListener {
            webView.reload()
        }

    }

    // 그냥 class 라고 하면 상위 클래스에 접근 못함
    // inner 라고 지정해줘야 상위클래스에 접근 가능
    inner class WebViewClient: android.webkit.WebViewClient() { // WebViewClient에 class 값을 설정
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url) // 페이지가 다 로딩되었을때

            refreshLayout.isRefreshing = false
        }
    }

    companion object {
        private const val DEFAULT_URL = "http://www.google.com"
    }

}