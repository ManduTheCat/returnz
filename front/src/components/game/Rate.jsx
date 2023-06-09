import React from 'react';
import tw, { styled } from 'twin.macro';
import { useSelector } from 'react-redux';
import { Popover, PopoverHandler, PopoverContent, Button } from '@material-tailwind/react';
import { changeInterest } from '../../store/gamedata/GameData.selector';
import imgpath from './assets/rateHelp.png';

export default function Rate() {
  const rateData = useSelector(changeInterest);
  console.log(rateData);
  return (
    <RateContanier>
      {/* <div className="absolute right-4 top-2">?</div> */}
      <div className="mb-1 text-center">
        <div className="font-bold text-lg"> 환율 </div>
        <div> {rateData.exchangeRate.toFixed(2)} 원</div>
      </div>
      <div className="mb-1 text-center">
        <div className="font-bold text-lg"> 금리🇰🇷 </div>
        <div> {rateData.korea} %</div>
      </div>
      <div className="mb-1 text-center">
        <div className="font-bold text-lg"> 금리🇺🇸 </div>
        <div> {rateData.usa} %</div>
      </div>
      <div className="absolute top-2 right-4">
        <Popover
          animate={{
            mount: { scale: 1, y: 0 },
            unmount: { scale: 0, y: 25 },
          }}
          placement="right-start"
        >
          <PopoverHandler>
            <Button variant="gradient" color="white" size="sm" className="border border-negative">
              ?
            </Button>
          </PopoverHandler>
          <PopoverContent className="z-20 shadow-xl shadow-gray-600">
            {' '}
            <img src={imgpath} alt="" />
          </PopoverContent>
        </Popover>
      </div>
    </RateContanier>
  );
}

const RateContanier = styled.div`
  ${tw`border h-[8%] flex place-content-evenly bg-white rounded-xl relative pr-12`}
`;
