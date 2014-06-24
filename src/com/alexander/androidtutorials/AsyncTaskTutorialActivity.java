package com.alexander.androidtutorials;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

public class AsyncTaskTutorialActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_async_task_tutorial);

		
		// NOT: AsyncTask’ın oluşturulma yapısına dikkat ederseniz
		// AsyncTask<Tip1,Tip2,Tip3> şeklinde bir yapı görürsünüz. Burada Tip1
		// doInBackground metoduna verilecek parametrelerin tipini ya da
		// sınıfını belirler (örnekte Void). Tip2 doInBackground metodunun
		// işleyişi sırasında onProgressUpdate metoduna paslanacak değişkenin
		// tipini ya da sınıfını belirtir. Tip3 ise onPostExecute metoduna
		// verilen değişkendir ve aynı zamanda doInBackground metodunun return
		// tipidir.
		new AsyncTask<Void, Integer, Void>() {
			ProgressDialog	progressDialog;

			// Arka plan işlemi başlamadan önce ön yüzde değiştirilmesi istenen
			// değişkenlerin (ProgressBar gibi animasyonlar) ve AsyncTask içinde
			// gerekli değişkenlerin değer ataması yapılır.
			@Override
			protected void onPreExecute()
			{
				super.onPreExecute();

				progressDialog = new ProgressDialog(AsyncTaskTutorialActivity.this);
				progressDialog.setMax(100);
				progressDialog.setProgress(0);
				progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				progressDialog.show();

			}

			// Arka planda yapılması istenen işlem burada gerçekleşir. Bu metod
			// içinde yapılan işlemler ön yüzde kullanıcının uygulamayı
			// kullanmasını kesinlikle etkilemez. Eğer buradaki işlemler
			// sonucunda ana akışa bir değişken gönderilmesi gerekiyorsa return
			// metodu ile bu değişken onPostExecute metoduna paslanabilir.
			@Override
			protected Void doInBackground(Void... params)
			{
				for (int i = 0; i < 101; i = i + 10)
				{
					try
					{
						publishProgress(i);
						Thread.sleep(1000);
					}
					catch (InterruptedException e)
					{}
				}
				return null;
			}

			// doInBackground metodu tamamlandıktan sonra işlemlerin sonucu bu
			// metoda result değişkeni ile gönderilir. Buradaki işlemler ana
			// akışı etkiler ve herhangi bir hataya sebep olmaz. Arka plandaki
			// işlemden gelen bir veri ön yüzde gösterilmek isteniyorsa bu metod
			// içinde gösterim işlemi yapılabilir.
			@Override
			protected void onPostExecute(Void result)
			{
				super.onPostExecute(result);
				progressDialog.dismiss();
			}

			// Eğer doInBackground metodu içerisinde yaptığınız işlemin ilerleme
			// durumunu (örneğin dosya indirme yüzdesi) kullanıcıya bildirmek
			// istiyorsanız bu metodu kullanabilirsiniz. doInBackground metodu
			// içerisinde publishProgress metodunu kullanarak ilerleme durumunu
			// onProgressUpdate metoduna iletip önyüz içerisinde buna göre bir
			// animasyon yapabilirsiniz.
			@Override
			protected void onProgressUpdate(Integer... values)
			{
				super.onProgressUpdate(values);

				Integer currentProgress = values[0];
				progressDialog.setProgress(currentProgress);
			}

			// Eğer herhangi bir sebepten dolayı AsyncTask iptal edilirse bu
			// metod uyarılır. Burada kullanıdığınız kaynakları
			// temizleyebilirsiniz.
			@Override
			protected void onCancelled(Void result)
			{
				super.onCancelled(result);
				progressDialog.dismiss();
			}
		}.execute();
	}
}
