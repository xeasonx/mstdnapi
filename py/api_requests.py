import requests
import traceback

from api_properties import *


def api_request(url: str, method: str, handler, custom_headers=None, **kwargs):
    """
    wrap "request" method
    :param url: request url
    :param method: request method
    :param handler: ResponseHandler class to process response, must implement "handle" method
    :param custom_headers: additional request headers, it will be combined with BASE_HEADERS
    :param kwargs: arguments pass to "request" method, if request has a body, one of the following arguments must be
                   provided: "data", "params", "json", "files"
                   Do not provide any arguments that is not supported by "request" method, or errors will raise.
    :return:
    """
    response = None
    response_json = None
    if custom_headers is not None and type(custom_headers is dict):
        custom_headers.upddate(BASE_HEADERS)
    else:
        custom_headers = BASE_HEADERS
    try:
        response = requests.request(method, url, headers=custom_headers, **kwargs)
    except requests.exceptions.RequestException:
        traceback.print_exc()
        return response, response_json
    else:
        if response.status_code == 200:
            response_json = response.json()
    return response, handler.handle(response_json)
