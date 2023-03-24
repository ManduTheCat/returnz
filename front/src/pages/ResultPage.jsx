import React from 'react';
import tw, { styled } from 'twin.macro';
import { Link } from 'react-router-dom';
import ResultRank from '../components/result/rank/ResultRank';
import ResultInfo from '../components/result/info/ResultInfo';
import UnlockResult from '../components/result/UnlockResult';
import Chatting from '../components/chatting/Chatting';

export default function ResultPage() {
  // api 요청하기
  return (
    <ResultContainer>
      <ResultRank />
      <ResultInfo />
      <LeftBottomSection>
        <UnlockResult />
        <Button to="/">나가기</Button>
      </LeftBottomSection>
      <Chatting />
    </ResultContainer>
  );
}

const ResultContainer = styled.div`
  ${tw`gap-[20px] mt-[40px] w-[75%] grid`}
  grid-template: 3fr 2fr / 1fr 2fr;
`;

const LeftBottomSection = styled.div`
  ${tw`flex flex-col gap-5`}
`;

const Button = styled(Link)`
  ${tw`border bg-white rounded-xl w-[100%] min-h-[50px] flex justify-center items-center`}
`;
