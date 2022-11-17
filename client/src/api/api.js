import axios from "axios";

const url = "http:/localhost/"

export function getAllHistories() {

    const jsonReturn = axios.get(url + "History");

    return JSON.parse(jsonReturn);
}

export function getSpecificHistory(id) {

    const jsonReturn = axios.get(url + "History/" + id);

    return JSON.parse(jsonReturn)
}