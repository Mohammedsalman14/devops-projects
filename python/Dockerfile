FROM python:alpine

WORKDIR /app

COPY 'main.py' /app

ENV NAME TEST

RUN pip install django


CMD [ "python","main.py" ]