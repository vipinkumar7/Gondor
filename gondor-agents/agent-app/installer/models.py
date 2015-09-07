from django.db import models

# Create your models here.

class Host(models.Model):
	name=models.CharField(max_length=200)
	ip=models.CharField(max_length=200)
	isPresent =models.BooleanField(False)



	
