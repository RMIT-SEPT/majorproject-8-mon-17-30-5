import React from 'react';
import { configure } from 'enzyme';
import WorkerForm from './WorkerForm';
import Adapter from 'enzyme-adapter-react-16';
import {cleanup} from '@testing-library/react';
import ShallowRenderer from 'react-test-renderer/shallow';

afterEach(cleanup);

configure({ adapter: new Adapter() });

it("render admin adding worker form correctly", () =>{
    const renderer = new ShallowRenderer();
    renderer.render(<WorkerForm/>);
    const result = renderer.getRenderOutput();
    expect(result.type).toBe('div');
    expect(result.props.children).toHaveLength(5);
});
