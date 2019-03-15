 //处理文件返回操作  视频相关，图片相关  修改MediaStore.Video.Media.EXTERNAL_CONTENT_URI   Video->IMAGE 即可
 @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (Build.VERSION.SDK_INT >= 19) {
                handlePathOnKitKat(data);
            } else {
                handlePathBeforeKitKat(data);
            }
        }
    }

    private void handlePathBeforeKitKat(Intent data) {
        mPath = data.getData().getPath();
    }

    @TargetApi(19)
    private void handlePathOnKitKat(Intent data) {
        String path = null;
        Uri uri = data.getData();
        Log.d("EditorActivity", "handlePathOnKitKat:" + DocumentsContract.isDocumentUri(this, uri));
        if (DocumentsContract.isDocumentUri(this, uri)) {
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1];
                String selection = MediaStore.Video.Media._ID + "=" + id;
                path = getPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                path = getPath(contentUri, null);
            } else if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                path = Environment.getExternalStorageDirectory() + "/" + uri.getPath().split(":")[1];
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            path = getPath(uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            path = uri.getPath();
        }
        mPath = path;

    }

    private String getPath(Uri uri, String selection) {
        String path = null;
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }
