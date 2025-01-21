import { useEffect } from "react";

interface TEProps {
  id: string;
  text: string;
  typeSpeed?: number;
  callback?: () => void;
  className?: string;
}

const TypingEffect: React.FC<TEProps> = ({
  id,
  text,
  typeSpeed = 60,
  callback,
  className,
}) => {
  useEffect(() => {
    let i = 0;
    let timeoutId: number | NodeJS.Timeout;
    const typedElement = document.getElementById(id);

    if (typedElement) {
      typedElement.innerHTML = "";
      const typeChar = () => {
        if (i < text.length) {
          typedElement.innerHTML += text.charAt(i);
          i++;
          timeoutId = setTimeout(typeChar, typeSpeed);
        } else if (callback) {
          callback();
        }
      };
      typeChar();
    }

    // Cleanup function to clear the timeout
    return () => clearTimeout(timeoutId);
  }, [id, text, typeSpeed, callback]);

  return <div id={id} className={className}></div>;
};

export default TypingEffect;
