server {
    listen       80;
    server_name  101.42.254.179;

    location / {
        root   /root/web/myblog/blog;
        index  index.html index.htm;
        try_files $uri $uri/ /index.html;
    }

	  location ^~ /api/ {
        proxy_pass http://101.42.254.179:8087/;
        proxy_set_header   Host             $host;
        proxy_set_header   X-Real-IP        $remote_addr;
        proxy_set_header   X-Forwarded-For  $proxy_add_x_forwarded_for;
    }

}

server {
    listen       80;
    server_name  admin.hhbs.top;

    location / {
        root   /root/web/myblog/blog;
        index  index.html index.htm;
        try_files $uri $uri/ /index.html;
    }

	  location ^~ /api/ {
        proxy_pass http://101.42.254.179:8087/;
        proxy_set_header   Host             $host;
        proxy_set_header   X-Real-IP        $remote_addr;
        proxy_set_header   X-Forwarded-For  $proxy_add_x_forwarded_for;
    }

 }
