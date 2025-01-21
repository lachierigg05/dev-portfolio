"use client";

import { useState, useEffect } from "react";
import TypingEffect from "./Animations/TypingEffect";
import Navbar from "../../../../../portfolio/portfolio/frontend/app/Components/Navbar";
import { Meteors } from "./Animations/MeteorEffect";
import "../../../../../portfolio/portfolio/frontend/app/page.css";

export default function FrontPage() {
  const [showDesc, setShowDesc] = useState(false);
  const [showButton, setShowButton] = useState(false);
  const [showMeteors, setShowMeteors] = useState(false);

  useEffect(() => {
    const timer = setTimeout(() => {
      setShowDesc(true);
    }, 1000);

    const buttonTimer = setTimeout(() => {
      setShowButton(true);
    }, 1000);

    const meteorTimer = setTimeout(() => {
      setShowMeteors(true);
    }, 1110);

    return () => {
      clearTimeout(timer);
      clearTimeout(buttonTimer);
      clearTimeout(meteorTimer);
    };
  }, []);

  return (
    <div className="bg-neutral-900 h-screen w-full max-w-full overflow-hidden">
      <Navbar />
      <div className="bg-neutral-950 flex justify-center flex-col items-center text-center w-full h-[100%] border border-neutral-950 shadow-d shadow-white">
      {showMeteors && <Meteors number={20} />}
        <div className="font-popsies text-8xl text-orange-200 fade-in">
          Lachie Rigg
        </div>
        {!showDesc && <div className="mt-[68px] mb-[64px]"></div>}
        {showDesc && (
          <TypingEffect
            id="desc"
            text="Full Stack Web Developer"
            className="font-roboto text-2xl mt-10 mb-16 text-orange-100"
          />
        )}
        <button
          type="button"
          onClick={() => window.scrollBy({ top: window.innerHeight, behavior: "smooth" })}
          className={`font-roboto text-orange-100 hover:text-white border border-gray-800 hover:bg-neutral-900 focus:ring-4 focus:outline-none focus:ring-gray-300 font-medium rounded-lg text-sm px-10 py-2.5 text-center ${
            showButton ? "fade-in" : "invisible"
          }`}
        >
          Click Here To See My Work!
        </button>
      </div>
    </div>
  );
}
