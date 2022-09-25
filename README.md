# webcrawler
webcrawler api to search text

	1. After staring the spring boot api.


	2.Go to http://localhost:8080/swagger-ui.html#!/web-crawl-controller/addUsingPOST


	3. do the search with searchText and with urls u want to find .
	 {
		"searchText": "python",
		"urlList": [
			"https://www.javatpoint.com/"
		 ,
		 "https://www.python.org/"
		]
	}


	4. You will get the result in following format
	[
		{
			"url": "https://www.javatpoint.com/",
			"foundedNode": "text found : <a href=\"python-tutorial\"><img src=\"https://static.javatpoint.com/images/icon/python.png\" alt=\"python\"> Python</a>",
			"found": true
		},
		{
			"url": "https://www.python.org/",
			"foundedNode": "text found : <title>Welcome to Python.org</title>",
			"found": true
		}
	]
	
	5.will get this error if invalid urls have entered - www..abc.com :URL is wronge
	{
  "searchText": "string",
  "urlList": [
    "www..abc.com"
  ]
}

