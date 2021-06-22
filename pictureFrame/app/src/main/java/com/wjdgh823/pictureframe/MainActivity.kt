package com.wjdgh823.pictureframe

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    val addPhotoButton: Button by lazy {
        findViewById<Button>(R.id.addPhotoButton)
    }

    private val startPhotoFrameModeButton: Button by lazy {
        findViewById<Button>(R.id.startPhotoFrameModeButton)
    }

    private val imageViewList: List<ImageView> by lazy {
        mutableListOf<ImageView>().apply {
            add(findViewById(R.id.imageView11))
            add(findViewById(R.id.imageView12))
            add(findViewById(R.id.imageView13))
            add(findViewById(R.id.imageView21))
            add(findViewById(R.id.imageView22))
            add(findViewById(R.id.imageView23))
        }
    }

    private val imageUriList: MutableList<Uri> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAddPhotoButton()
        initStartPhotoFrameModeButton()
    }

    private fun initAddPhotoButton() { //사진을 추가하는 버튼 이벤트
        addPhotoButton.setOnClickListener {
            when {
                ContextCompat.checkSelfPermission( // 권한을 물어보기 위한 함수
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE  // 저장소에대한 권한이 필요하기에
                ) == PackageManager.PERMISSION_GRANTED -> {
                    // TODO 권한이 잘 부여되었을 때 갤러리에서 사진을 선택하는 기능
                    navigatePhotos()
                }
                shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE) -> {
                    // TODO 교육용 팝업 확인 후 권한 팝업을 띄우는 기능
                    showPermissionContextPopup()
                }
                else -> {
                    requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
                }
            }
        }
    }

    private fun initStartPhotoFrameModeButton() {
        startPhotoFrameModeButton.setOnClickListener {
            val intent = Intent(this, PhotoFrameActivity::class.java)
            imageUriList.forEachIndexed { index, uri ->
                intent.putExtra("photo$index", uri.toString())
            }
            intent.putExtra("photoListSize", imageUriList.size)
            startActivity(intent)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            1000 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // todo 권한이 부여된 것입니다.
                    navigatePhotos()
                } else {
                    Toast.makeText(this, "권한을 거부하셨습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
                //
            }
        }
    }

    private fun navigatePhotos() {
        val intent = Intent(Intent.ACTION_GET_CONTENT) // saf기능으로 content를 가져오는 역할을 한다. : ACTION_GET_CONTENT
        intent.type = "image/*" // type중 이미지만 가져올 수 있도록 필터링한것이다.
        startActivityForResult(intent, 2000) // 보내기위해서 실행하는 함수
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {  // 데이터를 받아온다.
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK) { // RESULT_OK / RESULT_CANCEL을 통해 값을 받아왔는지 안받았는지 확인 가능
            return
        }

        when(requestCode) {
            2000-> {
                val selectedImageUri: Uri? = data?.data
                if (selectedImageUri != null){
                    if (imageUriList.size == 6) {
                        Toast.makeText(this, "이미 사진이 꽉 찼습니다.", Toast.LENGTH_SHORT).show()
                        return
                    }
                     imageUriList.add(selectedImageUri)
                     imageViewList[imageUriList.size-1].setImageURI(selectedImageUri)
                } else {
                    Toast.makeText(this, "사진을 가져오지 못했습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            else-> {
                Toast.makeText(this, "사진을 가져오지 못했습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showPermissionContextPopup() {
        AlertDialog.Builder(this)
            .setTitle("권한이 필요합니다.")
            .setMessage("전자 액자앱에서 사진을 불러오기 위해 권한이 필요핣니다.")
            .setPositiveButton("동의하기") { _, _ ->
                requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1000)
            }
            .setNegativeButton("취소하기") { _, _ ->}
            .create()
            .show()
    }



}