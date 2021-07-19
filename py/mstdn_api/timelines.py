from api_properties import *
from api_requests import api_request
from api_response_handlers import TimelineHandler


class Timeline:
    @classmethod
    def public(cls, query_args, method="GET", custom_headers=None, **kwargs):
        """
        :param query_args: query string in url, key value pairs
        :param handler: ResponseHandler class to process response, must implement "handle" method
        :param method: request method default is "GET"
        :param custom_headers: additional request headers
        :param kwargs: arguments pass to "request" method, if request has a body, one of the following arguments must be
                       provided: "data", "params", "json", "files"
                       Do not provide any arguments that is not supported by "request" method, or errors will raise.
        :return:
        """
        url = "{}/{}/public".format(URL, ENDPOINTS["timelines"])
        return api_request(url, method, TimelineHandler, custom_headers, params=query_args, **kwargs)

    @classmethod
    def tag(cls, query_args, hashtag, method="GET", custom_headers=None, **kwargs):
        url = "{}/{}/tag/{}".format(URL, ENDPOINTS["timelines"], hashtag)
        return api_request(url, method, TimelineHandler, custom_headers, params=query_args, **kwargs)

    @classmethod
    def home(cls, query_args, method="GET", custom_headers=None, **kwargs):
        url = "{}/{}/home".format(URL, ENDPOINTS["timelines"])
        return api_request(url, method, TimelineHandler, custom_headers, params=query_args, **kwargs)

    @classmethod
    def list(cls, query_args, list_id, method="GET", custom_headers=None, **kwargs):
        url = "{}/{}/list/{}".format(URL, ENDPOINTS["timelines"], list_id)
        return api_request(url, method, TimelineHandler, custom_headers, params=query_args, **kwargs)