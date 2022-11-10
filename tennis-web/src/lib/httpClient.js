import axios from "axios";

let headers = {
    "Content-Type": "application/json",
    Accept: `application/vnd.iman.v1+json, application/json, text/plain, */*`,
    "Access-Control-Allow-Origin": "*",
    "Cache-Control": "no-store, no-cache, must-revalidate",
    Pragma: "no-cache"
};

const filterOptions = ({method, ...rest}) => rest;

const fetch = async (url, options = {}) => {
    try {
        const instance = axios.create({
            baseURL: `http://localhost:8080/springtennis/api/v1`
        });

        // INTERCEPTOR REQUEST
        instance.interceptors.request.use(
            (conf) => {
                //console.log('1 Interceptor request conf: ', conf);
                return conf;
            },
            (error) => {
                return Promise.reject(error);
            }
        );

        // INTERCEPTOR RESPONSE
        instance.interceptors.response.use(
            (response) => {
                //console.log('Interceptor response: ', response);
                return response;
            },
            (error) => {
                //console.log('Interceptor response error: ', error);
                return Promise.reject(error);
            }
        );

        const {data} = await instance.request({
            url,
            data: options["data"],
            params: options["params"],
            method: options["method"],
            headers: {...headers, ...options["headers"]},
            cancelToken: options["cancelFn"]
                ? new axios.CancelToken(options["cancelFn"])
                : null
        });

        return data;
    } catch (err) {
        if (axios.isCancel(err)) {
            throw new Error("request-cancelled");
        } else {
            throw err;
        }
    }
};

const get = async (url, options = {}) => {
    return await fetch(url, {
        method: "GET",
        ...filterOptions(options)
    });
};

const post = async (url, options = {}) => {
    return await fetch(url, {
        method: "POST",
        ...filterOptions(options)
    });
};

const put = async (url, options = {}) => {
    return await fetch(url, {
        method: "PUT",
        ...filterOptions(options)
    });
};

const del = async (url, options = {}) => {
    return await fetch(url, {
        method: "DELETE",
        ...filterOptions(options)
    });
};

export default {
    get,
    post,
    put,
    delete: del
};
