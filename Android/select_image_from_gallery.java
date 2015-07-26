private void selectImageFromGallery()
{
	private static final int SELECT_PHOTO = 100;
	Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
	photoPickerIntent.setType("image/*");
	startActivityForResult(photoPickerIntent, SELECT_PHOTO);   
	
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) { 
    super.onActivityResult(requestCode, resultCode, imageReturnedIntent); 

    switch(requestCode) { 
    case SELECT_PHOTO:
        if(resultCode == RESULT_OK){  
            Uri selectedImage = imageReturnedIntent.getData();
            InputStream imageStream = getContentResolver().openInputStream(selectedImage);
            Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
			
			
			try {
			   saveImageToSdCard(yourSelectedImage);
			} catch (Exception e) {
			   e.printStackTrace();
			}
        }
    }
}
