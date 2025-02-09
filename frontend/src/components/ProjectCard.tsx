import React from 'react';

interface Props {
    title: string;
    des?: string;
    imgSrc: string;
}

const ProjectCard: React.FC<Props> = ({title, des = "No Description", imgSrc}) => {
    return (
        <div className='m-4 p-4 h-1/2 w-full text-white flex flex-col border-white border-2 rounded-lg justify-center items-center'>
            <div className='p-4'>
                <h1 className='text-2xl font-bold mb-2'>{title}</h1>
                <p className='text-lg'>{des}</p>
            </div>
            <img src={imgSrc} alt='Project Image' className='w-full h-48 object-cover rounded-t-lg'/>
        </div>
    )
}

export default ProjectCard;