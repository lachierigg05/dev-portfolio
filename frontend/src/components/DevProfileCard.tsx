import React from 'react';

const DevProfileCard: React.FC = () => {
    return (
        <div className='flex flex-col justify-start h-screen w-1/2'>
            <div className='flex flex-col m-20 mt-24'>
                <h1 className='m-2 mb-4 text-7xl font-medium font-popsies text text-yellow-200 w-full'>Lachie Rigg</h1>
                <h2 className='m-2 mb-6 mt-7 text-xl font-medium font-roboto text text-gray-200'>Junior Full-Stack
                    Engineer</h2>
                <span className='m-2 mt-7 text-m font-light font-roboto text text-gray-300'>
                    Hi, I'm Lachie!
                </span>
                <span className='m-2 mt-7 text-m font-light font-roboto text text-gray-300'>
                    I’m a passionate full-stack developer with a deep love for technology and a strong commitment to lifelong learning. As a soon-to-be graduate of UNSW’s Computer Science program, I am dedicated to continuously expanding my knowledge and skills in the ever-evolving field of software engineering.
                </span>
                <span className='m-2 mt-7 text-m font-light font-roboto text text-gray-300'>
                    I love technology and thrive on building software that delivers exceptional user experiences. I enjoy solving complex problems and creating solutions that transform challenging tasks into effortless and engaging interactions.                </span>
                <div className="flex w-full justify-start m-2 mt-16">
                    <a href="https://github.com/lachierigg05">
                        <img className='mr-8' src='src/assets/logos/github.svg' alt='Github Logo'/>
                    </a>
                    <a href="https://www.linkedin.com/in/lachlan-rigg-b0249b218/">
                        <img className='mr-10' src='src/assets/logos/linkedIn.svg' alt='LinkedIn Logo'/>
                    </a>
                    <a href="mailto:lachrigg@gmail.com">
                        <img src='src/assets/logos/email.svg' alt='Email Logo'/>
                    </a>
                </div>
            </div>
        </div>
    );
};

export default DevProfileCard;
