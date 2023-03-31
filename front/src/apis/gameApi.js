import { axios, authApi } from './axiosConfig';

const makeRoomApi = async () => {
  return authApi
    .post('/wait-room')
    .then((res) => {
      console.log('방만들기 성공', res);
      return res.data;
    })
    .catch((err) => {
      console.log('방만들기 실패', err);
      return err;
    });
};

const startGameApi = async (payload) => {
  const res = await authApi.post('/games/init', payload);
  return res.data;
};

const gameDataApi = (payload) => {
  console.log(payload);
  return authApi
    .post('/games/game', payload)
    .then((res) => {
      console.log('데이터 가져오기 성공', res);
      return res.data;
    })
    .catch((err) => {
      console.log('데이터 가져오기 실패', err);
      return err;
    });
};
const resultApi = (param, payload) => {
  // return axios.get(`url${param}`, { payload });
};

export { makeRoomApi, startGameApi, gameDataApi, resultApi };
