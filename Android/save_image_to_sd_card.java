private void saveImage() {
        File filename;
        try {
            String path = Environment.getExternalStorageDirectory().toString();
            new File(path + "/mvc/mvc").mkdir();
            filename = new File(path + "/mvc/mvc/var3.jpg");
            FileOutputStream out = new FileOutputStream(filename);
            bmImg.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            MediaStore.Images.Media.insertImage(getContentResolver(),
                    filename.getAbsolutePath(), filename.getName(),
                    filename.getName());
            bt.setText("Saved...");
            Toast.makeText(getApplicationContext(),
                    "File is Saved in  " + filename, 1000).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
  
//Second Method    
private void saveImageToSdCard(Bitmap bitmap)
{
	
	File sdCardDirectory = Environment.getExternalStorageDirectory();
	File image = new File(sdCardDirectory, "test.png");
	
	  boolean success = false;

    // Encode the file as a PNG image.
    FileOutputStream outStream;
    try {
        outStream = new FileOutputStream(image);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream); 
        /* 100 to keep full quality of the image */
        outStream.flush();
        outStream.close();
        success = true;
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
	
    if (success) {
        Toast.makeText(getApplicationContext(), "Image saved with success",
                Toast.LENGTH_LONG).show();
    } else {
        Toast.makeText(getApplicationContext(),
                "Error during image saving", Toast.LENGTH_LONG).show();
    }
}
    
    
    
