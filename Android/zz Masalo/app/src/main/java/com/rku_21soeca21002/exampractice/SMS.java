// Call
btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  long number = Long.parseLong(edtphone.getText().toString().trim());
                try{
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+edtphone.getText().toString().trim()));
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
		
// SMS
btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                        sendsms();
                    }else {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS},1);
                    }
                }
            }
        });

		private void sendsms() {
        String number = edtnumbersms.getText().toString().trim();
        String sms = edtsms.getText().toString().trim();
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number,null,sms,null,null);
            Toast.makeText(this, "send SMS", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }
	
// Splash
Timer t = new Timer();
TimerTask tt=new TimerTask(){
	public void run(){
			startActivity(new Intent(splash.this,Main.class));
			finish();
	}
};
t.schedule(tt,2000);

//