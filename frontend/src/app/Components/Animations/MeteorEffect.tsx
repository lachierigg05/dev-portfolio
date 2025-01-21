import clsx from "clsx";
import React, { useState, useEffect } from "react";

export const Meteors = ({ number }: { number?: number }) => {
  const [screenWidth, setScreenWidth] = useState(window.innerWidth);
  const [isResizing, setIsResizing] = useState(false);

  useEffect(() => {
    let resizeTimeout: NodeJS.Timeout;

    const handleResize = () => {
      setIsResizing(true);
      setScreenWidth(window.innerWidth);

      document.body.classList.add('disable-animations');

      clearTimeout(resizeTimeout);
      resizeTimeout = setTimeout(() => {
        setIsResizing(false);
        document.body.classList.remove('disable-animations');
      }, 500); // Adjust the timeout duration as needed
    };

    window.addEventListener('resize', handleResize);
    return () => window.removeEventListener('resize', handleResize);
  }, []);

  const getLeftValue = () => {
    const range = screenWidth > 800 ? screenWidth / 2 : screenWidth / 10;
    return Math.floor(Math.random() * range) + "px";
  };

  const meteors = screenWidth > 800 ? new Array(number || 20).fill(true) : new Array(10).fill(true);
  return (
    <>
      {meteors.map((el, idx) => (
        <span
          key={"meteor" + idx}
          className={clsx(
            "animate-meteor-effect absolute top-1/2 left-1/2 h-0.5 w-0.5 rounded-[9999px] bg-slate-500 shadow-[0_0_0_1px_#ffffff10] rotate-[215deg]",
            "before:content-[''] before:absolute before:top-1/2 before:transform before:-translate-y-[50%] before:w-[50px] before:h-[1px] before:bg-gradient-to-r before:from-[#64748b] before:to-transparent",
            { "animation-none": isResizing }
          )}
          style={{
            top: 0,
            left: getLeftValue(),
            animationDelay: Math.random() * (0.8 - 0.2) + 0.2 + "s",
            animationDuration: Math.floor(Math.random() * (10 - 2) + 2) + "s",
          }}
        ></span>
      ))}
    </>
  );
};